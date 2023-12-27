package com.springboot.assignment3.service;

import com.itextpdf.text.DocumentException;
import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.model.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    Schedule addMakeAnAppointment(ScheduleDTO scheduleDTO);

    Schedule confirm( int id);

    Schedule unConfirm(int id,String description);

    List<Schedule> detailScheduleOfDoctor(int id);

    List<Schedule> detailScheduleOfUser(int id);

    Schedule findbyScheduleId(int id);

    byte[] generatePdfFile(Schedule schedule) throws DocumentException;
}
