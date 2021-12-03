import { getData, getOrders } from "./integration/Integration";
import { useState } from "react";
import './App.css';

function App() {
    const [list, setList] = useState("")
    async function callTheApi() {
        // mockApi();
        let orders = await getOrders();
        console.log(orders.data);
        setList(orders.data);
    }
    function mockApi() {
        setTimeout(() => {
            setList([
                {
                    id: '01',
                    name: 'John Deu',
                    description: 'john@gmail.com',
                },
                {
                    id: '02',
                    name: 'Brad Pitt',
                    description: 'fightclud@gmail.com',
                },
            ]);
        }, 1200);
    }

    return (
        <>
            <div class="list">
                {list ? list.map((data) => (
                    <div class="list-element" key={data.id}>
                        <div class="el-id">
                            <div class="label">ID</div>
                            <div class="value">{data.id}</div>
                        </div>
                        <div class="el-info">
                            <div class="el-name">
                                <div class="label">NAME</div>
                                <div class="value">{data.name}</div>
                            </div>
                            <div class="el-desc">
                                <div class="label">DESCRIPTION</div>
                                <div class="value">{data.description}</div>
                            </div>
                        </div>
                    </div>
                )) :
                    <div class="loader-container">
                        <div class="loader-content">
                            <button class="refresh" onClick={callTheApi}>Refresh my list</button>
                            <div class="loader-main">
                                <div class="loader loader-1"></div>
                                <div class="loader loader-2"></div>
                                <div class="loader loader-3"></div>
                            </div>
                        </div>
                    </div>}
            </div>
        </>
    )
}

export default App
