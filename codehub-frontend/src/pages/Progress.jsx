import { useEffect, useState } from "react";
import api from "../services/api";

function Progress() {

    const [progress, setProgress] = useState(null);

    const fetchProgress = async () => {

        try {

            const token = localStorage.getItem("token");

            const response = await api.get(
                "/progress",
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            setProgress(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    useEffect(() => {

        fetchProgress();

    }, []);

    if (!progress) {
        return <h2>Loading...</h2>;
    }

    return (

        <div>

            <h1>My Progress</h1>

            <table border="1">

                <tbody>

                    <tr>
                        <td>Total Solved</td>
                        <td>{progress.totalSolved}</td>
                    </tr>

                    <tr>
                        <td>Easy Solved</td>
                        <td>{progress.easySolved}</td>
                    </tr>

                    <tr>
                        <td>Medium Solved</td>
                        <td>{progress.mediumSolved}</td>
                    </tr>

                    <tr>
                        <td>Hard Solved</td>
                        <td>{progress.hardSolved}</td>
                    </tr>

                </tbody>

            </table>

        </div>

    );
}

export default Progress;