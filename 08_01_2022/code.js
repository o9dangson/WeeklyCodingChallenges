/* 
    NOTE: Not part of my technology stack. However, attempted for fun.

    Create a function that repeats a specific given char 'x' times.
    Input: string and number
    Output: String

   
    Examples:
    repeat("-", 3) ➞ "---"
    repeat("A", 0) ➞ ""
    repeat("c", -1) ➞ ""

    Notes:
    - Tests can repeat a char 268435440 times, no more.
    - Repeat should be fast maximum execution time : 5 ms.
    - Total maximum execution time : 3800 ms.
    - Native repeat is forbidden.
    - Using of an existing repeat polyfill too (that's not the challenge objective).

*/

function repeat(pattern, num){
    let result = ''
    //Check if Num valid range
    if (num > 0){
        let repeat_count = num
        if (num > 268435440)
            repeat_count = 268435440
        while ( repeat_count > 1){
            if (repeat_count & 1)
                result += pattern
            repeat_count >>= 1
            pattern += pattern
        }
        result += pattern
    }
    return result
}

function test_repeat(){
    let test_chars = ["-", "A", "c", "a"]
    let test_nums = [3, 0, -1, 268435441]
    let expected = [3, 0, 0, 268435440]

    for(let i=0; i<test_chars.length; i++){
        let actual = repeat(test_chars[i], test_nums[i])
        console.log(`Char: ${test_chars[i]}\tNumber: ${test_nums[i]}\n\tExpected Length:\t${expected[i]}\n\tActual Length:\t\t${actual.length}`)
    }
}

test_repeat()