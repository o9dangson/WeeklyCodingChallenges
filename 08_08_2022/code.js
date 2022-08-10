/* 
    NOTE: Not part of my technology stack. However, attempted for fun.

    Write a function that mimics (without the use of >>) the right shift
    operator and returns the result from the two given integers.
    Input: string and number
    Output: String

   
    Examples:
    shiftToRight(80, 3) ➞ 10 
    shiftToRight(-24, 2) ➞ -6
    shiftToRight(-5, 1) ➞ -3
    shiftToRight(4666, 6) ➞ 72
    shiftToRight(3777, 6) ➞ 59
    shiftToRight(-512, 10) ➞ -1

    Notes:
    - There will be no negative values for the second parameter y.
	- This challenge is more like recreating of the right shift 
        operation, thus, the use of the operator directly is prohibited.
    - Alternatively, you can solve this challenge via recursion.

*/

function shiftToRight(num, power){
    let result = num
    //Code Logic Here
    // Loop Logic
    let num_to_repeat = power
    
    while(num_to_repeat > 0){
        //Shift right
        result = Math.floor(result / 2)
        //Decrement
        num_to_repeat--
    }
    
    // // Recursive Logic
    // // Base Case
    // if (power == 0){
    //     return num
    // }
    // // Else
    // if (power > 0){
    //     return shiftToRight(Math.floor(num/2), power - 1)
    // }
    return result
}

function test_shiftToRight(){
    let test_nums = [80, -24, -5, 4666, 3777, -512]
    let test_power = [3, 2, 1, 6, 6, 10]
    let expected = [10, -6, -3, 72, 59, -1]

    for(let i=0; i<test_nums.length; i++){
        let actual = shiftToRight(test_nums[i], test_power[i])
        console.log(`Number: ${test_nums[i]}\tPower: ${test_power[i]}\n`
                    +`\tExpected:\t${expected[i]}\n\tActual:\t\t${actual}`)
    }
}

test_shiftToRight()