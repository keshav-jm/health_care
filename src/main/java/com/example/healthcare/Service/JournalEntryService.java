package com.example.healthcare.Service;

import com.example.healthcare.Repository.JournalEntryRepository;
import com.example.healthcare.model.JournalEntry;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public JournalEntry createEntry(JournalEntry entry) {
        if (entry.getEntryDate() == null || entry.getEntryDate().trim().isEmpty()) {
            entry.setEntryDate(LocalDate.now().toString());
        }
        return journalEntryRepository.save(entry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }
}