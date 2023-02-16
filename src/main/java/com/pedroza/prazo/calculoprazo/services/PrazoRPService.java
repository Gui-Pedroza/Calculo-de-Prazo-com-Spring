package com.pedroza.prazo.calculoprazo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroza.prazo.calculoprazo.entities.PrazoRP;

@Service
public class PrazoRPService extends PrazoService {

	@Autowired
	PrazoRP prazoRP;

	@Override	
	public void loadHolidays() {
		try (BufferedReader br = new BufferedReader(new FileReader(prazoRP.getCaminhoArquivo()))) {
			String lines = br.readLine();
			while (lines != null) {
				if (prazoRP.getHolidays().isPresent()) {
					prazoRP.getHolidays().get().add(LocalDate.parse(lines));
				}

				lines = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Arquivo não encontrado " + e.getMessage());
		}
		
	}

	
	public LocalDate addBusinessDays(LocalDate startDate, int days) {

		if (startDate == null || days <= 0 || prazoRP.getHolidays() == null) {
			throw new IllegalArgumentException("Invalid method argument(s) " + "to addBusinessDays(" + startDate + ","
					+ days + "," + prazoRP.getHolidays() + ")");
		}

		Predicate<LocalDate> isHoliday = date -> prazoRP.getHolidays().isPresent()
				? prazoRP.getHolidays().get().contains(date)
				: false;

		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		LocalDate result = startDate;
		while (days > 0) {
			result = result.plusDays(1);
			if (isHoliday.or(isWeekend).negate().test(result)) {
				days--;
			}
		}
		return result;
	}

}
