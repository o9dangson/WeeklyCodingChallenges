#Project Onboarding 08/01/2022 - Coding Challenge

# Create a program that will recursively count the number of digits of a number.
# Conversion of the number to a string is not allowed, thus, the approach is recursive.

# All inputs are integers but some are in exponential form, deal with it accordingly.


def digits_count(number: int) -> int:
    # Convert Num to Int just in case
    number = (int) (number)
    # Base Case
    if (number <= 9 and number >= 0):
        return 1
    if (number >=-9 and number <= 0):
        return 1
    # If larger than 10
    if (number > 9 or number < 0):
        smaller_num = (int) (number / 10)
        return 1 + digits_count(smaller_num)

def test_digits_count():
    # Test Cases
    vars = [4666, 544, 121317, 0, 12345, 1289396387328, 1.2e4, -123]
    expected = [4, 3, 6, 1, 5, 13, 5, 3]
    # Print results
    for i in range(len(vars)):
        print(f'digits_count({vars[i]}) => \n\texpected: \t{expected[i]} ; \tactual: \t{digits_count(vars[i])}')

def main():
    test_digits_count()

if __name__ == '__main__':
    main()