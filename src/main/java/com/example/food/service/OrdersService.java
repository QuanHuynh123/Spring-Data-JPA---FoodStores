package com.example.food.service;

import com.example.food.dto.OrdersCountDTO;
import com.example.food.dto.OrdersDTO;
import com.example.food.entity.OrdersEntity;
import com.example.food.enums.AppException;
import com.example.food.mapper.OrdersMapper;
import com.example.food.repository.OrdersRepository;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.RichTextString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersMapper ordersMapper ;

    public List<OrdersDTO> getAllOrder(){
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public  List<OrdersDTO> getOrderByCustomerId(Integer id){
        List<OrdersEntity> ordersEntities = ordersRepository.findOrdersByCustomerId(id);
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public  List<OrdersDTO> getOrderByPhone(String phone){
        List<OrdersEntity> ordersEntities = ordersRepository.findOrdersByCustomerPhone(phone);
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersDTO> getAllOrdersOrderByDateAsc(){
        List<OrdersEntity> ordersEntities = ordersRepository.getAllOrdersOrderByDateAsc();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersDTO> getAllOrdersOrderByDateDesc(){
        List<OrdersEntity> ordersEntities = ordersRepository.getAllOrdersOrderByDateDesc();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersCountDTO> countOrdersInLastThreeMonths() {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3).withDayOfMonth(1).toLocalDate().atStartOfDay();
        return ordersRepository.countOrdersInLastThreeMonths(threeMonthsAgo);
    }

    public void generateExcel(HttpServletResponse response) throws IOException {
        List<OrdersDTO>  orders = getAllOrder();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Orders");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("OrderDate");
        row.createCell(2).setCellValue("OrderNumber");
        row.createCell(3).setCellValue("TotalAmount");

        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd"));

        int dataRowIndex =1 ;
        for (OrdersDTO ordersDTO : orders) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(ordersDTO.getId());
            HSSFCell dateCell = dataRow.createCell(1);
            dateCell.setCellValue(ordersDTO.getOrderDate());
            dateCell.setCellStyle(dateCellStyle);
            dataRow.createCell(2).setCellValue(ordersDTO.getOrderNumber());
            HSSFCell totalAmountCell = dataRow.createCell(3);
            totalAmountCell.setCellValue(ordersDTO.getTotalAmount().doubleValue());
            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
}
