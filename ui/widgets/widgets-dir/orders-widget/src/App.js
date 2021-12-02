import { getData } from "./integration/Integration";
import { useState } from "react";
import './App.css';

function App() {
    const [payload, setPayload] = useState("")
    async function callTheApi() {
        //mock api
        list = [
            {
                id: '01',
                name: 'John Deo',
                email: 'john@gmail.com',
                phone: '202-555-0163'
            },
            {
                id: '02',
                name: 'Brad Pitt',
                email: 'fightclud@gmail.com',
                phone: '202-555-0106'
            },
        ];
        setPayload((await getData()).data.payload)
    }
    var list;
    //call the api to retrieve list
    // callTheApi();

    return (
        <>
            <div class="list">
                    {list? list.map((data) => (
                        <div class="list-element" key={data.id}>
                            <p>{data.name}</p>
                            <p>{data.email}</p>
                            <p>{data.phone}</p>
                        </div>
                    )) : <div class="loader-container"><div class="loader"></div></div>}
            </div>
        </>
    )
}

export default App
