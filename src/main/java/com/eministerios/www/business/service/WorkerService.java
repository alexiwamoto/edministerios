package com.eministerios.www.business.service;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandre on 21/03/16.
 */
@Service
public class WorkerService {

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public void save(Worker worker) {
        workerRepository.save(worker);
    }

    public void remove(Worker worker) {
        workerRepository.delete(worker);
    }

    public List<Worker> findByProfession(String profession){
        return workerRepository.findByProfession(profession);
    }

}
