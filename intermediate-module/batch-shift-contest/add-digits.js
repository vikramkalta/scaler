function addDigits(A) {
    const str = A.toString();
    if (str.length <= 0) {
        return [-1];
    }
    const resultArr = [];
    let mid = A/2;
    for (let i = A; i > mid; i--) {
        let digitStr = i.toString();
        const sumOfDigits = getSumOfDigits(digitStr);
        const sum = i + sumOfDigits;
        if (sum === N) {
            resultArr.push(i);
        }
    }
    if (!resultArr.length) {
        return [-1];
    }
    return resultArr.sort();
}

function getSumOfDigits(digits) {
    let sum = 0;
    for (let i = 0, len = digits.length; i < len; i++) {
        sum += parseInt(digits[i]);
    }
    return sum;
}

console.log(addDigits(20));

    // 50
    // 25 - 25 + 2 + 5 = 32
    // 26 - 26 + 2 + 6 = 34
    // 27 - 27 + 2 + 7 = 36
    // 28 - 28 + 2 + 8 = 38
    // 29 - 29 + 2 + 9 = 40
    // 30 - 30 + 3 + 0 = 33
    // 31 - 31 + 3 + 1 = 35
    // 32 - 32 + 3 + 2 = 37
    // 33 - 33 + 3 + 3 = 39
    // 34 - 34 + 3 + 4 = 41
    // 35 - 35 + 3 + 5 = 43
    // 36 - 36 + 3 + 6 = 45
    // 37 - 37 + 3 + 7 = 47
    // 38 - 38 + 3 + 8 = 49
    // 39 - 39 + 3 + 9 = 51
    // 40 - 40 + 4 + 0 = 44
    // 41 - 41 + 4 + 1 = 46
    // 42 - 42 + 4 + 2 = 48
    // 43 - 43 + 4 + 3 = 50