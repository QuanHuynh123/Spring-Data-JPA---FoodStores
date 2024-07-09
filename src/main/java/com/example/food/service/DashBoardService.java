package com.example.food.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class DashBoardService {
    LocalDate currenDate = LocalDate.now();
    Month currentMonth = currenDate.getMonth();


}
