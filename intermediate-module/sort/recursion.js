'use strict';

const object = {
    a: {
        ab: 1,
        ac: {
            aca: 2
        }
    },
    b: {
        ba: 3,
        bc: {
            bca: 4
        }
    },
    c: {
        cb: 5,
        ca: 6
    }
};

function rec(obj) {
    if (!Object.keys(obj).length) {
        console.log('object', obj);
    }
    let keys = Object.keys(obj);
    for (let i = 0; i < keys.length; i++) {
        const key = keys[i];
        rec(obj[key]);
    }
}

rec(object);