function matchInvoice(A, B, C, D) {
    const dueBalanceLen = A.length;
    let invoiceObj = {};
    for (let i = 0; i < dueBalanceLen; i++) {
        invoiceObj = {
            ...invoiceObj,
            [A[i]]: B[i]
        };
    }

    const paidChequeLen = C.length;
    let unmatchedChequeCount = 0;
    for (let i = 0; i < paidChequeLen; i++) {
        if (invoiceObj[C[i]] !== D[i]) {
            unmatchedChequeCount++;
        }
    }
    return unmatchedChequeCount;
}