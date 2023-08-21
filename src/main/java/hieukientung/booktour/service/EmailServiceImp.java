package hieukientung.booktour.service;

import hieukientung.booktour.model.Email;
import hieukientung.booktour.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
