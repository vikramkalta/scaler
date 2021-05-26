const mergeSort = (arr, p, r) => {
    if (p >= r) {
        return;
    }
    let q = Math.floor((p+r)/ 2);
    mergeSort(arr, p, q);
    mergeSort(arr,q+1,r);
    merge(arr, p, q, r);
    // return arr;
};

const merge = (arr, low, mid, high) => {
    const n1 = mid - low + 1;
    const n2 = high - mid;

    const left = [], right = [];
    for (let i = 0; i < n1; i++) {
        left[i] = arr[low + i];
    }
    for (let i = 0; i < n2; i++) {
        right[i] = arr[mid + i + 1];
    }

    let i = 0, j = 0, k = low;

    while (i < n1 && j < n2) {
        if (left[i] < right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        // if (left[i].productCount <= right[j].productCount) {
        //   arr[k] = left[i];
        //   i++;
        // } else {
        //   arr[k] = right[j];
        //   j++;
        // }
        k++;
    }

    while (i < n1) {
        arr[k] = left[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = right[j];
        j++;
        k++;
    }
};

// export { mergeSort };

const arr = [3, 4, 2, 5, 1];
mergeSort(arr, 0, arr.length - 1);