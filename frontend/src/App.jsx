import { useState } from "react";
import "./App.css";

function App() {
  const [a, setA] = useState("");
  const [b, setB] = useState("");
  const [result, setResult] = useState("");

  const calculate = async (operation) => {
    try {
        const response = await fetch(`https://calculator-production-6906.up.railway.app/${operation}`, {        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Basic " + btoa("admin:password"),
        },
        body: JSON.stringify({
          firstNumber: Number(a),
          secondNumber: Number(b),
        }),
      });

      const data = await response.text();

        if (!response.ok) {
            try {
                const error = JSON.parse(data);
                setResult("⚠️ " + error.message);
            } catch {
                setResult("⚠️ Something went wrong");
            }
            return;
        }

      setResult(data);
    } catch (error) {
      setResult("Unable to connect to backend");
    }
  };

  return (
      <div className="calculator">
        <h1>Calculator</h1>

        <input
            type="number"
            placeholder="First number"
            value={a}
            onChange={(e) => setA(e.target.value)}
        />

        <input
            type="number"
            placeholder="Second number"
            value={b}
            onChange={(e) => setB(e.target.value)}
        />

        <div className="buttons">
          <button onClick={() => calculate("add")}>+</button>
          <button onClick={() => calculate("subtract")}>−</button>
          <button onClick={() => calculate("multiply")}>×</button>
          <button onClick={() => calculate("divide")}>÷</button>
        </div>

        <h2>{result}</h2>
      </div>
  );
}

export default App;