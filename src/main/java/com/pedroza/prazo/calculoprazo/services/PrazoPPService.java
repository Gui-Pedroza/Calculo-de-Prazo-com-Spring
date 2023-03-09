package com.pedroza.prazo.calculoprazo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroza.prazo.calculoprazo.entities.PrazoPresidentePrudente;

@Service
public class PrazoPPService extends PrazoService {

	@Autowired
	PrazoPresidentePrudente prazoPP;

	private Predicate<LocalDate> isHoliday = date -> prazoPP.getHolidays().isPresent()
			? prazoPP.getHolidays().get().contains(date)
			: false;

	private Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
			|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

	@Override
	public void loadHolidays() {
		try (BufferedReader br = new BufferedReader(new FileReader(prazoPP.getCaminhoArquivo()))) {
			String lines = br.readLine();
			while (lines != null) {
				if (prazoPP.getHolidays().isPresent()) {
					prazoPP.getHolidays().get().add(LocalDate.parse(lines));
				}

				lines = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Arquivo de leitura não encontrado " + e.getMessage());
		}
	}

	// caso a data inicial seja feriado ou dia útil, o método retornará o próximo
	// dia útil subsequente
	public LocalDate diaUtilSubsequente(LocalDate startDate) {
		LocalDate proximoDia = startDate;
		while (isHoliday.or(isWeekend).test(proximoDia)) {
			proximoDia = proximoDia.plusDays(1);
		}
		return proximoDia;
	}

	@Override
	public LocalDate addBusinessDays(LocalDate startDate, int days) {

		if (startDate == null || days <= 0 || prazoPP.getHolidays() == null) {
			throw new IllegalArgumentException("Invalid method argument(s) " + "to addBusinessDays(" + startDate + ","
					+ days + "," + prazoPP.getHolidays() + ")");
		}

		LocalDate result = diaUtilSubsequente(startDate);
		while (days > 0) {
			result = result.plusDays(1);
			if (isHoliday.or(isWeekend).negate().test(result)) {
				days--;
			}
		}
		return result;
	}

}
