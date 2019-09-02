package com.example.test.Service;

import com.example.test.Commons.Transactions;
import com.example.test.DTO.DashboardResponseDTO;
import com.example.test.DTO.GetReportsByTimeDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DashboardService {



    @Value("${transaction.url}")
    public String url;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PatientRepository patientRepository;


    private List<Transactions> getTransactionsBytimeNaccount(GetReportsByTimeDTO getReportsByTimeDTO) {
        RestTemplateResponseDTO restTemplateResponseDTO=restTemplate.postForObject(url+"dashboard/account",getReportsByTimeDTO,RestTemplateResponseDTO.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                restTemplateResponseDTO.getBodyList(),
                new TypeReference<List<Transactions>>() {
                }
        );
    }

    private List<Transactions> getTransactionsBytime(GetReportsByTimeDTO getReportsByTimeDTO) {
        RestTemplateResponseDTO restTemplateResponseDTO=restTemplate.postForObject(url+"dashboard/all",getReportsByTimeDTO,RestTemplateResponseDTO.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                restTemplateResponseDTO.getBodyList(),
                new TypeReference<List<Transactions>>() {
                }
        );
    }


    public List<DashboardResponseDTO> getDashboardTotalAmount(GetReportsByTimeDTO getReportsByTimeDTO)
    {
        List<Transactions> transactions = getTransactionsBytimeNaccount(getReportsByTimeDTO);

        Map<String,Double> totalAmountMap = new HashMap<>();
        List<String> operations= Arrays.asList("ER","CONSULTANCY","OBSERVATION","GYNY","BED","LABTEST");

        operations.forEach(ops->totalAmountMap.put(ops,0.0));


//        DateFormat Date = DateFormat.getDateInstance();

        String type="";

        for(Transactions trans : transactions){
                type =trans.getOperationType();
                if(totalAmountMap.containsKey(type)){
                    totalAmountMap.put(type,totalAmountMap.get(type)+trans.getTotalAmount());
                }
                else {
                    totalAmountMap.put(type,trans.getTotalAmount());
                }

        }

        List<DashboardResponseDTO> totalAmount = new ArrayList<>();
        Set<String> keys=totalAmountMap.keySet();


        keys.forEach((key)-> totalAmount.add(new DashboardResponseDTO(key,totalAmountMap.get(key).toString())));
        return totalAmount;

    }



    public List<DashboardResponseDTO> getDashboardTotalAmountByTime(GetReportsByTimeDTO getReportsByTimeDTO)
    {
        List<Transactions> transactions = getTransactionsBytimeNaccount(getReportsByTimeDTO);
        Map<String,Double> map = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        transactions.forEach((trans)->
        {
            if (map.containsKey(dateFormat.format(trans.getTransactionDate()).toString())) {
                map.put(dateFormat.format(trans.getTransactionDate()).toString(), map.get(dateFormat.format(trans.getTransactionDate()).toString()) + trans.getTotalAmount());
            } else {
                map.put(dateFormat.format(trans.getTransactionDate()).toString(), trans.getTotalAmount());
            }
        });
        List<DashboardResponseDTO> totalAmountList=new ArrayList<>();
        Set<String> keys=map.keySet();

        keys.forEach(key-> totalAmountList.add(new DashboardResponseDTO(key,map.get(key).toString())));

        return totalAmountList;
    }



    public List<DashboardResponseDTO> getDashboardDues(GetReportsByTimeDTO getReportsByTimeDTO) {

        List<Transactions> transactions = getTransactionsBytime(getReportsByTimeDTO);
        Map<String,Double> duesMap = new HashMap<>();



        List<String> operations= Arrays.asList("ER","CONSULTANCY","OBSERVATION","GYNY","BED","LABTEST");

        operations.forEach(ops->duesMap.put(ops,0.0));

        transactions.forEach((trans)->
        {
            if(duesMap.containsKey(trans.getOperationType()))
            {
                duesMap.put(trans.getOperationType(),duesMap.get(trans.getOperationType())+trans.getDues());
            }
            else
            {
                duesMap.put(trans.getOperationType(),trans.getDues());
            }


        });

        Set<String> keys=duesMap.keySet();
        List<DashboardResponseDTO> dues=new ArrayList<>();

        keys.forEach(key->dues.add(new DashboardResponseDTO(key,duesMap.get(key).toString())));
        return dues;
    }

    public List<DashboardResponseDTO> getDashboardDuesByTime(GetReportsByTimeDTO getReportsByTimeDTO)
    {
        List<Transactions> transactions = getTransactionsBytime(getReportsByTimeDTO);
        Map<String,Double> map = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        transactions.forEach((trans)->
        {
            if (map.containsKey(dateFormat.format(trans.getTransactionDate()).toString())) {
                map.put(dateFormat.format(trans.getTransactionDate()).toString(), map.get(dateFormat.format(trans.getTransactionDate()).toString()) + trans.getDues());
            } else {

                map.put(dateFormat.format(trans.getTransactionDate()).toString(), trans.getDues());
            }
        });

        List<DashboardResponseDTO> duesList=new ArrayList<>();
        Set<String> keys=map.keySet();

        keys.forEach(key-> duesList.add(new DashboardResponseDTO(key,map.get(key).toString())));

        return duesList;
    }

    public List<DashboardResponseDTO> getDashboardPatients(GetReportsByTimeDTO getReportsByTimeDTO)
    {
        List<Patient> patients = patientRepository.getCountOfPatientByDate(getReportsByTimeDTO.getFrom(),getReportsByTimeDTO.getTill());


        Map<String,Long> map = new HashMap<>();
        Long inital =1l;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String date="";

        for(Patient p : patients){
            date = dateFormat.format(p.getDate()).toString();
            if(map.containsKey(date)){
                map.put(date,map.get(date)+1);
            }
            else {
                map.put(date,inital);
            }

        }

        List<DashboardResponseDTO> patientList = new ArrayList<>();
        Set<String> keys=map.keySet();


        keys.forEach((key)-> patientList.add(new DashboardResponseDTO(key,map.get(key).toString())));
        return patientList;

    }


    public List<Transactions> getAllHospitalTransactions(GetReportsByTimeDTO getReportsByTimeDTO){

        RestTemplateResponseDTO restTemplateResponseDTO = restTemplate.postForObject(url+"dashboard/hospitalreports",getReportsByTimeDTO,RestTemplateResponseDTO.class);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(
                restTemplateResponseDTO.getBodyList(),
                new TypeReference<List<Transactions>>(){}

        );
    }

    public List<Transactions> getAllDoctorTransactions(GetReportsByTimeDTO getReportsByTimeDTO){

        RestTemplateResponseDTO restTemplateResponseDTO = restTemplate.postForObject(url+"dashboard/doctortransactions",getReportsByTimeDTO,RestTemplateResponseDTO.class);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(
                restTemplateResponseDTO.getBodyList(),
                new TypeReference<List<Transactions>>(){}
        );
    }

    public List<Transactions> getAlltransactions(GetReportsByTimeDTO getReportsByTimeDTO) {
        RestTemplateResponseDTO restTemplateResponseDTO = restTemplate.postForObject(url+"dashboard/employeereports", getReportsByTimeDTO, RestTemplateResponseDTO.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                restTemplateResponseDTO.getBodyList(),
                new TypeReference<List<Transactions>>(){}
        );

    }



    }
