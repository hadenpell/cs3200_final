const URL = "http://localhost:8080/api";

export const findAllRecords = (table) =>
    fetch(`${URL}/${table}`)
        .then(response => response.json());

export const findRecordById = (table, id) =>
    fetch(`${URL}/${table}/${id}`)
        .then(response => response.json());

export const findOneToManyRecords = (oneTable, id, manyTable) =>
    fetch(`${URL}/${oneTable}/${id}/${manyTable}`)
        .then(response => response.json());

export const removeRecord = (table, id) =>
    fetch(`${URL}/${table}/${id}`, {
        method: "DELETE"
    })

export const createRecord = (record, table) => {
    return fetch(`${URL}/${table.name}`, {
        method: 'POST',
        body: JSON.stringify(record),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())
}

export const createOneToMany = (oneTable, id, manyTable) =>
    fetch(`${URL}/${oneTable}/${id}/${manyTable}/create`);


export const updateRecord = (table, id, newRecord) => {
    return fetch(`${URL}/${table}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(newRecord),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())
}

// TODO: export all functions as the API to this service
export default {
    findAllRecords,
    findRecordById,
    findOneToManyRecords,
    removeRecord,
    createRecord,
    createOneToMany,
    updateRecord
}