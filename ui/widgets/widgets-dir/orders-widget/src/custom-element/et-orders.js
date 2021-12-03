import ReactDOM from "react-dom"
import React from "react"
import App from '../App'



class EtApp extends HTMLElement {
    connectedCallback() {
        this.mountPoint = document.createElement('div')
        this.render()
    }

    render() {
        ReactDOM.render(<React.StrictMode>
                    <App/>
            </React.StrictMode>,
            this.appendChild(this.mountPoint))
    }
}

customElements.get('et-orders') || customElements.define("et-orders", EtApp)
