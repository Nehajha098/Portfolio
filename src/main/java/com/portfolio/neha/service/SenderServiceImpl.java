package com.portfolio.neha.service;

import com.portfolio.neha.model.Sender;
import com.portfolio.neha.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImpl implements SenderService{

    @Autowired
    private SenderRepository senderRepository;

    @Override
    public void saveIdentity(Sender sender) {
        senderRepository.save(sender);
    }
}
