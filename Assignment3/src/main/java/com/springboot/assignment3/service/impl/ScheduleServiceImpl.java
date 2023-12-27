package com.springboot.assignment3.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.springboot.assignment3.dao.DoctorUserRepository;
import com.springboot.assignment3.dao.PatientRepository;
import com.springboot.assignment3.dao.ScheduleRepository;
import com.springboot.assignment3.dao.UserRepository;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Patient;
import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.ScheduleDTO;
import com.springboot.assignment3.model.UserPrincipal;
import com.springboot.assignment3.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.function.ServerResponse;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import javax.print.Doc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorUserRepository doctorUserRepository;

    @Autowired
    SpringTemplateEngine templateEngine;
    @Override
    public Schedule addMakeAnAppointment(ScheduleDTO scheduleDTO) {
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Schedule schedule = new Schedule();
        DoctorUser doctorUser = doctorUserRepository.findById(scheduleDTO.getDoctorUser().getId()).orElse(null);
        schedule.setDoctorUser(doctorUser);

        schedule.setTime(scheduleDTO.getTime());
        schedule.setExaminationPrice(scheduleDTO.getExaminationPrice());
        schedule.setPathological(scheduleDTO.getPathological());

        Patient patient = patientRepository.findByUserId(currentUser.getId()).orElse(null);
        schedule.setPatient(patient);
        scheduleRepository.save(schedule);
        return schedule;
    }

    @Override
    public Schedule confirm(int id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        schedule.setStatus(1);
        scheduleRepository.save(schedule);
        return schedule;
    }

    @Override
    public Schedule unConfirm(int id,String description) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        schedule.setStatus(2);
        schedule.setDescription(description);
        scheduleRepository.save(schedule);
        return schedule;
    }

    @Override
    public List<Schedule> detailScheduleOfDoctor(int id) {
        List<Schedule> schedules = scheduleRepository.findByDoctorUserId(id);
        return schedules;
    }

    @Override
    public List<Schedule> detailScheduleOfUser(int id) {
        List<Schedule> schedules = scheduleRepository.findByPatientId(id);
        return schedules;
    }

    @Override
    public Schedule findbyScheduleId(int id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        return schedule;
    }

    @Override
    public byte[] generatePdfFile(Schedule schedule) throws DocumentException {
        Document document = new Document(PageSize.A5.rotate());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            //create file pdf
            PdfWriter pdfWriter = PdfWriter.getInstance(document,byteArrayOutputStream);
            document.open();

            // created a thymeleaf context with data
            Context context = new Context();
            context.setVariable("data",schedule);

            // process the HTML template with thymeleaf and get the processed results
            String processedHTML = templateEngine.process("pdf.html",context);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(processedHTML.getBytes(StandardCharsets.UTF_8));
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter,document,byteArrayInputStream);

            document.close();
            pdfWriter.close();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception ex){
            ex.printStackTrace();
            throw new DocumentException("Có lỗi xảy ra " + ex.getMessage());
        }
    }


}
