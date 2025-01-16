package com.task.invoice.core.configuration;

import com.task.invoice.core.entities.Invoice;
import com.task.invoice.core.entities.Role;
import com.task.invoice.core.helpers.RoleHelper;
import com.task.invoice.core.entities.User;
import com.task.invoice.core.repositories.InvoiceRepository;
import com.task.invoice.core.repositories.RoleRepository;
import com.task.invoice.core.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final InvoiceRepository invoiceRepository;

    @PostConstruct
    public void init() {
        if (roleRepository.findAll().isEmpty()) {
            Role rAdmin = new Role(RoleHelper.ADMIN.getValue());
            rAdmin.setDescription("Mindenhez hozzáfér");
            Role rAccountant = new Role(RoleHelper.ACCOUNTANT.getValue());
            Role rUser = new Role(RoleHelper.USER.getValue());
            roleRepository.saveAll(List.of(rAdmin, rAccountant, rUser));
            System.out.println("Role repository was empty");
        }
        if (userRepository.findAll().isEmpty()) {
            User admin = new User("admin", "asd123",
                    List.of(roleRepository.findByName(RoleHelper.ADMIN.getValue())));
            User accountant = new User("konyvelo", "asd123",
                    List.of(roleRepository.findByName(RoleHelper.ACCOUNTANT.getValue())));
            User user = new User("user", "asd123",
                    List.of(roleRepository.findByName(RoleHelper.USER.getValue())));
            userRepository.saveAll(List.of(admin, accountant, user));
            System.out.println("User repository was empty");
        }

        if (invoiceRepository.findAll().isEmpty()) {
            invoiceRepository.save(new Invoice("Vásárló", LocalDate.now(), LocalDate.now(), "Item", "Komment", 20));
            System.out.println("Invoice repository was empty");
        }
    }
}
