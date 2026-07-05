import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../services/api";

function ProblemDetails() {

    const { id } = useParams();

    const [problem, setProblem] = useState(null);
    const [code, setCode] = useState("");
    const [language, setLanguage] = useState("Java");

    const fetchProblem = async () => {

        try {

            const token = localStorage.getItem("token");

            const response = await api.get(
                `/problems/${id}`,
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            setProblem(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    useEffect(() => {

        fetchProblem();

    }, []);

    if (!problem) {
        return <h2>Loading...</h2>;
    }

    const handleSubmit = async () => {

        try {

            const token = localStorage.getItem("token");

            const response = await api.post(
                "/submissions",
                {
                    problemId: problem.id,
                    code: code,
                    language: language
                },
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            console.log(response.data);

            alert("Solution submitted successfully!");

        } catch (error) {

            console.log(error);

            alert("Submission failed!");

        }
    };

    return (
        <div>

            <h1>{problem.title}</h1>

            <h3>Difficulty: {problem.difficulty}</h3>

            <p>{problem.description}</p>
            <h3>Language</h3>

            <select
                value={language}
                onChange={(e) => setLanguage(e.target.value)}
            >
                <option>Java</option>
                <option>C++</option>
                <option>Python</option>
            </select>

            <h3>Code</h3>

            <textarea
                rows="18"
                cols="100"
                value={code}
                onChange={(e) => setCode(e.target.value)}
            />

            <br /><br />

            <button onClick = {handleSubmit}>
                Submit Solution
            </button>

        </div>
    );
}

export default ProblemDetails;