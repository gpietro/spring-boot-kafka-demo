import React, {useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

const App = () => {

    useEffect(() => {
        console.log('init')
        const eventSource = new EventSource('http://localhost:9999/iq/v1/locations');
        eventSource.onopen = (event) => console.log('open', event);
        eventSource.onmessage = (event) => {
            console.log('event', event.data)
            //const location = JSON.parse(event.data).source;
            //console.log(`location: ${location}`);
        };
        eventSource.onerror = (event) => console.log('error', event);
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
