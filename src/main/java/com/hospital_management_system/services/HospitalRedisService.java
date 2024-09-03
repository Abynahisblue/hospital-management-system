package com.hospital_management_system.services;

import com.hospital_management_system.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HospitalRedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void savePatientToList(String listKey, Patient patient) {
        redisTemplate.opsForList().leftPush(listKey, patient);
    }

    public Patient getPatientFromList(String listKey) {
        return (Patient) redisTemplate.opsForList().leftPop(listKey);
    }

    public void saveDoctorSpecialty(String hashKey, String doctorId, String specialty) {
        redisTemplate.opsForHash().put(hashKey, doctorId, specialty);
    }

    public String getDoctorSpecialty(String hashKey, String doctorId) {
        return (String) redisTemplate.opsForHash().get(hashKey, doctorId);
    }
}
