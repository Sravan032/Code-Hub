import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../services/api";

function ProblemDetails() {

    const { id } = useParams();

    const [problem, setProblem] = useState(null);

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

    return (
        <div>

            <h1>{problem.title}</h1>

            <h3>Difficulty: {problem.difficulty}</h3>

            <p>{problem.description}</p>

        </div>
    );
}

export default ProblemDetails;