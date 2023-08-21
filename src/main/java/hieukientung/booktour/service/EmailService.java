package hieukientung.booktour.service;

import hieukientung.booktour.model.Email;
import hieukientung.booktour.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmailService {
    public List<Email> getAllEmails();
}
