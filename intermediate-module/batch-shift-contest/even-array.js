function evenArray(a) {
    const len = a.length;
    if (len % 2 !== 0) {
        return "NO";
    }
    const resultArr = [];
    let subArr = [];
    for (let i = 0; i < len; i++) {
        subArr.push(a[i]);
        if (subArr.length % 2 === 0
            && subArr[0] % 2 === 0
            && subArr[subArr.length - 1] % 2 === 0) {
            resultArr.push(subArr);
            subArr = [];
        }
    }

    if (subArr.length) {
        return "NO"; // Subarray contains odd numbers
    } else if (resultArr.length && !subArr.length) {
        return "YES"; // Last element and first element is even in all subarrays
    } else {
        return "NO";
    }
}

// evenArray([1, 2, 3, 4, 6, 9, 10, 12,13, 15, 19,12]);
evenArray([2, 4, 8, 6, 7, 8]);
evenArray([978,847,95,729,778,586,188,782,813,870,871,940,312,693,580]);