package com.jsp.Pharmacy.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Pharmacy.Application.dto.MedicineDto;
import com.jsp.Pharmacy.Application.entity.Medicine;
import com.jsp.Pharmacy.Application.service.MedicineService;
import com.jsp.Pharmacy.Application.util.ResponseStructure;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	
	@Autowired
	private MedicineService service;
	

	@PostMapping
	public ResponseEntity<ResponseStructure<MedicineDto>> saveMedicine(@RequestParam int storeId,@RequestBody Medicine  medicine){
		return service.saveMedicine(storeId,medicine);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<MedicineDto>> updateMedicine(@RequestParam int medicineId,@RequestBody Medicine medicine){
		return service.updateMedicine(medicineId,medicine);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicine(@RequestParam int medicineId){
		return service.findMedicine(medicineId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedicineDto>> deleteMedicine(@RequestParam int medicineId){
		return service.deleteMedicine(medicineId);
	}
	@GetMapping("/findbyname")
	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicineByName(@RequestParam String medicineName){
		return service.findMedicineByName(medicineName);
	}
}
