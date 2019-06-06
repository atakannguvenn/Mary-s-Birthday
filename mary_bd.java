package Birthday;

import java.time.MonthDay;
import java.util.Scanner;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.Month.*;

public class mary_bd {
	
	private static Predicate<MonthDay> byMonth(Month month) {
		return x -> x.getMonth().equals(month);
	}

	private static Predicate<MonthDay> byDay(int day) {
		return x -> x.getDayOfMonth() == day;
	}
	
	private static Predicate<MonthDay> isDayUniqueWithin(List<MonthDay> dates) {
		return x -> dates.stream()
				.filter(byDay(x.getDayOfMonth()))
				.count() == 1;
	}
	
	private static Predicate<MonthDay> isMonthUniqueWithin(List<MonthDay> dates) {
		return x -> dates.stream()
				.filter(byMonth(x.getMonth()))
				.count() == 1;
	}
	
	private static Predicate<MonthDay> isMonthWithUniqueDayWithin(List<MonthDay> dates) {
		return x -> dates.stream()
				.filter(isDayUniqueWithin(dates))
				.filter(byMonth(x.getMonth()))
				.count() == 1;
	}
	
	public static void main(String[] args) {
		List<MonthDay> possibleBirthdays = Arrays.asList(
			MonthDay.of(JANUARY, 5), MonthDay.of(JANUARY, 6), MonthDay.of(JANUARY, 9),
			MonthDay.of(FEBRUARY, 7), MonthDay.of(FEBRUARY, 8),
			MonthDay.of(MARCH, 4), MonthDay.of(MARCH, 6),
			MonthDay.of(APRIL, 4), MonthDay.of(APRIL, 5), MonthDay.of(APRIL, 7)
		);
		
		List<MonthDay> possibleBirthdays2 = Arrays.asList(
				MonthDay.of(MAY, 15), MonthDay.of(MAY, 16), MonthDay.of(MAY, 19),
				MonthDay.of(JUNE, 17), MonthDay.of(JUNE, 18),
				MonthDay.of(JULY, 14), MonthDay.of(JULY, 16),
				MonthDay.of(AUGUST, 14), MonthDay.of(AUGUST, 15), MonthDay.of(AUGUST, 17)
		);
		
		List<MonthDay> possibleBirthdays3 = Arrays.asList(
				MonthDay.of(MARCH, 3), MonthDay.of(MARCH, 4), MonthDay.of(MARCH, 7),
				MonthDay.of(JUNE, 3), MonthDay.of(JUNE, 6),
				MonthDay.of(SEPTEMBER, 1), MonthDay.of(SEPTEMBER, 4),
				MonthDay.of(DECEMBER, 1), MonthDay.of(DECEMBER, 2), MonthDay.of(DECEMBER, 7)
		);
		
		System.out.println("Please enter which question you would like to solve (1-3)");
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		input.close();
		System.out.println("Starting candidate dates:");
		if (x == 1){
			System.out.println(possibleBirthdays);
			
			possibleBirthdays = possibleBirthdays.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays).negate())
					.filter(isMonthWithUniqueDayWithin(possibleBirthdays).negate())
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after first sentence:");
			System.out.println(possibleBirthdays);
			
			possibleBirthdays = possibleBirthdays.stream()
					.filter(isDayUniqueWithin(possibleBirthdays))
					.collect(Collectors.toList());
					
			System.out.println("\nCandidate dates after second sentence:");
			System.out.println(possibleBirthdays);
			
			possibleBirthdays = possibleBirthdays.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays))
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after last sentence:");
			System.out.println(possibleBirthdays);
		}
		else if (x == 2){
			System.out.println(possibleBirthdays2);
			
			possibleBirthdays2 = possibleBirthdays2.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays2).negate())
					.filter(isMonthWithUniqueDayWithin(possibleBirthdays2).negate())
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after first sentence:");
			System.out.println(possibleBirthdays2);
			
			possibleBirthdays2 = possibleBirthdays2.stream()
					.filter(isDayUniqueWithin(possibleBirthdays2))
					.collect(Collectors.toList());
					
			System.out.println("\nCandidate dates after second sentence:");
			System.out.println(possibleBirthdays2);
			
			possibleBirthdays2 = possibleBirthdays2.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays2))
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after last sentence:");
			System.out.println(possibleBirthdays2);
		}
		
		else if (x == 3){
			System.out.println(possibleBirthdays3);
			
			possibleBirthdays3 = possibleBirthdays3.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays3).negate())
					.filter(isMonthWithUniqueDayWithin(possibleBirthdays3).negate())
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after first sentence:");
			System.out.println(possibleBirthdays3);
			
			possibleBirthdays3 = possibleBirthdays3.stream()
					.filter(isDayUniqueWithin(possibleBirthdays3))
					.collect(Collectors.toList());
					
			System.out.println("\nCandidate dates after second sentence:");
			System.out.println(possibleBirthdays3);
			
			possibleBirthdays3 = possibleBirthdays3.stream()
					.filter(isMonthUniqueWithin(possibleBirthdays3))
					.collect(Collectors.toList());
			
			System.out.println("\nCandidate dates after last sentence:");
			System.out.println(possibleBirthdays3);
		}
		
		else
			System.out.printf("You have entered invalid input");
	}	
}