import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ProtectedRoute from "./components/ProtectedRoute";
import Problems from "./pages/Problems";
import ProblemDetails from "./pages/ProblemDetails";
import MySubmissions from "./pages/MySubmissions";
import Progress from "./pages/Progress";
import Leaderboard from "./pages/Leaderboard";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>
                            <Dashboard />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/problems"
                    element={
                        <ProtectedRoute>
                            <Problems />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/leaderboard"
                    element={
                        <ProtectedRoute>
                            <Leaderboard />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/problems/:id"
                    element={
                        <ProtectedRoute>
                            <ProblemDetails />
                        </ProtectedRoute>
                    }
                />

                <Route
                    path="/submissions"
                    element={
                        <ProtectedRoute>
                            <MySubmissions />
                        </ProtectedRoute>
                    }
                />

                <Route
                    path="/progress"
                    element={
                        <ProtectedRoute>
                            <Progress />
                        </ProtectedRoute>
                    }
                />
            </Routes>
        </BrowserRouter>
    );
}

export default App;