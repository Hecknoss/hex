# Problem by Websten from forums
#
# Given your birthday and the current date, calculate your age in days.
# Account for leap days.

#Solution by Hex

def is_leap_year(year):
    if (year%4==0 and (year%100!=0 or year%400==0)):
        return True
    else:
        return False

def other_years(year1, year2):
    age_count = 0
    while year1 + 1 < year2:
        if is_leap_year(year1):
            age_count = age_count + 1
        age_count = age_count + 365
        year1 = year1 + 1
    return age_count


#this should add the days in the first year
def first_year(year1, month1, day1):
    daysOfMonths = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if is_leap_year(year1):
        daysOfMonths[1] = daysOfMonths[1] + 1
    yearone = sum(daysOfMonths[month1 + 1:])
    return daysOfMonths[month1] - day1 + yearone


#this should add the days in the last year
def last_year(year2, month2, day2):
    daysOfMonths = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if is_leap_year(year2):
        daysOfMonths[1] = daysOfMonths[1] + 1
    yeartwo = sum(daysOfMonths[:month2])
    return day2 + yeartwo


def daysBetweenDates(year1, month1, day1, year2, month2, day2):
    daysOfMonths = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    print "born: ", year1, month1, day1, "\nnow:  ", year2, month2, day2
#for list purposes we redefine the months
    month1 = month1 - 1
    month2 = month2 - 1
    age = 0

# to take care of same year situations.
    if year1 == year2:
        if year1 % 4 == 0:
            daysOfMonths[1] = daysOfMonths[1] + 1
        age = daysOfMonths[month1] - day1 + day2
        while month1 + 1 < month2:
            month1 += 1
            age =  age + daysOfMonths[month1] - day1 + day2

        print age, " - final age in same year if statement"
        return age

    else:
        age = age + first_year(year1, month1, day1)

        age = age + other_years(year1, year2)

        age = age + last_year(year2, month2, day2)

        print age, " - from else statement"

        return age
    #return result


def test():
    test_cases = [((2012,1,1,2012,2,28), 58),
                  ((2012,1,1,2012,3,1), 60),
                  ((2011,6,30,2012,6,30), 366),
                  ((2011,1,1,2012,8,8), 585 ),
                  ((1900,1,1,1999,12,31), 36523)]
    for (args, answer) in test_cases:
        result = daysBetweenDates(*args)
        if result != answer:
            print "Test with data:", args, "failed"
        else:
            print "Test case passed!"

test()
