import React, {useEffect, useState} from 'react';
import {format} from 'date-fns';
import './App.css';

const App = () => {

    const [patients, setPatients] = useState(new Map());

    useEffect(() => {
        console.log('init')
        const eventSource = new EventSource('http://localhost:9999/iq/v1/locations');
        eventSource.onopen = (event) => console.log('sse connection opened', event);
        eventSource.onmessage = (event) => {
            console.log('data', event.data)
            const patient = JSON.parse(event.data);
            console.log('patient', patient, '--->', patients)
            const key = `${patient.wardId}-${patient.patientId}`;
            setPatients(new Map(patients.set(key, patient)));
        };
        eventSource.onerror = (event) => console.log('sse connection error', event);
    }, [])

    return (
        <div className="App">
            <h1>Patients</h1>
            <ul>
                {Array.from(patients.keys()).map(key => <li
                    key={key}
                    style={{color: patients.get(key).status === 'ACTIVE' ? 'green' : 'red'}}>
                    [WardId {patients.get(key).wardId} {patients.get(key).roomId ? `/ Room ${patients.get(key).roomId}` : ''}
                    {patients.get(key).bedId ? `/ Bed ${patients.get(key).bedId}` : ''}]
                    &nbsp;#{patients.get(key).patientId} {patients.get(key).firstName} {patients.get(key).lastName} - {format(new Date(patients.get(key).birthDate), 'dd.MM.yyyy')}</li>
                )
                }
            </ul>
        </div>
    );
}


export default App;
