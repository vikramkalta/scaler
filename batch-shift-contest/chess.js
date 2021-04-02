function chess(A, B) {
    let [len, subArrayLen, subArr, resultArr, unhappinessCoefficient] = [A.length, Math.floor(A.length / B), [], [], 0];

    let [countOfIPawns, countOfJPawns] = [0,0];
    for (let i = 0; i < len; i++) {
        subArr.push(A[i]);
        if (A[i] === 0) {
            countOfIPawns++;
        } else {
            countOfJPawns++;
        }
        if (subArr.length === subArrayLen) {
            unhappinessCoefficient += countOfIPawns*countOfJPawns;
            subArr = [];
            countOfIPawns = 0;
            countOfJPawns = 0;
        }
    }
    if (subArr.length) {
        unhappinessCoefficient += countOfIPawns*countOfJPawns;
    }
    console.log('resultArr', resultArr);
    console.log('subArr', subArr);
    return unhappinessCoefficient;
}

// console.log(chess([0,1,0,1,1,1,0,1,1,0], 3));
// console.log(chess([1,1,0,1,1], 4));
console.log(chess([0,1,1,1,0,0,0,1,1], 3));