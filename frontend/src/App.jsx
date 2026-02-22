
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


import Welcome from './Welcome.jsx';

import ForgotPassword from './ForgotPassword.jsx';
import ForgotUsername from './ForgotUsername.jsx';
import AuthPage from './AuthPage.Jsx';



function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<AuthPage/>} />
        <Route path="/welcome" element={<Welcome />} />
         <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/forgot-username" element={<ForgotUsername />} />
      </Routes>
    </Router>
  );
}

export default App;