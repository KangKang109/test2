import React, { useEffect, useState } from "react";

function App() {
    const [count, setCount] = useState(0);
    const [lastLaunch, setLastLaunch] = useState("");

    useEffect(() => {
        // 1. 먼저 POST 요청으로 실행 기록 저장
        fetch("http://localhost:8080/api/launch", {
            method: "POST"
        })
        .then(() => {
            console.log("✅ Launch registered");

            // 2. POST 성공 후 count와 마지막 실행 시간 조회
            return fetch("http://localhost:8080/api/count");
        })
        .then(response => response.json())
        .then(data => {
            setCount(data.count);
            setLastLaunch(data.lastLaunch);  // 가장 최근 실행 시간 저장
        })
        .catch(error => console.error("❌ Error fetching count:", error));
    }, []);

    return (
        <div style={{ textAlign: "center", marginTop: "50px" }}>
            <h1>📊 강X우 금일 브라우저 실행 횟수</h1>
            <h2>{count/2+0.5} 회</h2>
            <h3>⏰ 가장 최근 실행: {lastLaunch}</h3>  {/* 최근 실행 시간 표시 */}
        </div>
    );
}

export default App;
