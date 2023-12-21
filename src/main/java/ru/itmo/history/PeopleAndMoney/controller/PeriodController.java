package ru.itmo.history.PeopleAndMoney.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.itmo.history.PeopleAndMoney.domain.Job;
import ru.itmo.history.PeopleAndMoney.domain.Period;
import ru.itmo.history.PeopleAndMoney.domain.Price;
import ru.itmo.history.PeopleAndMoney.domain.Salary;
import ru.itmo.history.PeopleAndMoney.service.JobService;
import ru.itmo.history.PeopleAndMoney.service.PeriodService;
import ru.itmo.history.PeopleAndMoney.service.PriceService;
import ru.itmo.history.PeopleAndMoney.service.SalaryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeriodController {
    private final PeriodService periodService;
    private final SalaryService salaryService;
    private final JobService jobService;
    private final PriceService priceService;

    public PeriodController(PeriodService periodService, SalaryService salaryService, JobService jobService, PriceService priceService) {
        this.periodService = periodService;
        this.salaryService = salaryService;
        this.jobService = jobService;
        this.priceService = priceService;
    }

    @GetMapping("period/all")
    public List<Period> getPeriods() {
        return periodService.findAll();
    }

    @GetMapping("period")
    public Period getPeriod(@RequestParam int year) {
        return periodService.findByYear(year);
    }

    @GetMapping("period/byId")
    public Period getPeriodById(@RequestParam long id) {
        return periodService.findById(id);
    }

    @GetMapping("salaries")
    public List<Salary> getSalariesByPeriod(@Valid @RequestParam Period period) {
        return salaryService.findAllByPeriod(period);
    }

    @GetMapping("prices")
    public List<Price> getPricesByPeriod(@Valid @RequestParam Period period) {
        return priceService.findPricesByPeriod(period);
    }

    @GetMapping("jobs")
    public List<Job> getJobs() {
        return jobService.findAll();
    }
}
