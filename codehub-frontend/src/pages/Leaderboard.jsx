import { useEffect, useState } from "react";
import api from "../services/api";

function Leaderboard() {

    const [leaderboard, setLeaderboard] = useState([]);

    const fetchLeaderboard = async () => {

        try {

            const response = await api.get("/leaderboard");

            setLeaderboard(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    useEffect(() => {

        fetchLeaderboard();

    }, []);

    return (

        <div>

            <h1>Leaderboard</h1>

            <table border="1">

                <thead>

                    <tr>

                        <th>Rank</th>
                        <th>Email</th>
                        <th>Solved Problems</th>

                    </tr>

                </thead>

                <tbody>

                    {
                        leaderboard.map((user, index) => (

                            <tr key={user.email}>

                                <td>{index + 1}</td>

                                <td>{user.email}</td>

                                <td>{user.solvedCount}</td>

                            </tr>

                        ))
                    }

                </tbody>

            </table>

        </div>

    );
}

export default Leaderboard;