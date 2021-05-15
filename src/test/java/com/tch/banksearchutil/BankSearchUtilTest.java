package com.tch.banksearchutil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.tch.banksearchutil.model.Bank;

/**
 * Unit test for simple App.
 */
public class BankSearchUtilTest {
	private ClassLoader classLoader = getClass().getClassLoader();

	@Test
	public void testParseToString() {
		URL banksFile = classLoader.getResource("banks.csv");

		List<String> banks = BankSearchUtil.parseToObject(banksFile.getPath(), Function.identity(), 1);

		assertEquals(11, banks.size());

	}

	@Test
	public void testParseToObject() {
		URL banksFile = classLoader.getResource("banks.csv");

		List<Bank> banks = BankSearchUtil.parseToObject(banksFile.getPath(), mapToBank, 1);

		assertEquals(11, banks.size());
		assertEquals(new Bank("1", "Amazing Bank", "Branch", "New York", "NY", "10018"), banks.get(0));
		assertEquals(new Bank("2", "Neighborhood Bank", "Branch", "New York", "NY", "10020"), banks.get(1));
	}

	@Test
	public void testSearchCityAndState() {
		System.out.println( " test Search City and State");
		URL banksFile = classLoader.getResource("banks.csv");

		List<Bank> banks = BankSearchUtil.parseToObject(banksFile.getPath(), mapToBank, 1);

		assertEquals(11, banks.size());
		List<Bank> result = banks.stream()
				.filter(item -> item.getState().equals("NY") && item.getCity().equals("New York"))
				.collect(Collectors.toList());

		result.forEach(System.out::println);

	}

	@Test
	public void testSearchZipCodeOrStateOrCityOrTypeOrBankName() {
		System.out.println( " test Search ZipCode Or State Or City Or Type Or BankName ");
		URL banksFile = classLoader.getResource("banks.csv");

		List<Bank> banks = BankSearchUtil.parseToObject(banksFile.getPath(), mapToBank, 1);

		assertEquals(11, banks.size());
		List<Bank> result = banks.stream()
				.filter(item -> item.getState().equals("NY") || item.getState().equals("NY")
						|| item.getState().equals("NY") || item.getState().equals("NY")
						|| item.getCity().equals("New York"))
				.collect(Collectors.toList());

		result.forEach(System.out::println);

	}

	private Function<String, Bank> mapToBank = line -> {
		String[] columns = line.split(",");
		return new Bank(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
	};

}
