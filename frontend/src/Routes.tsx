import Navbar from "components/Navbar";
import Admin from "pages/Admin";
import Home from "pages/Home";
import VideoDetails from "pages/VideoDetails";
import VideoList from "pages/VideoList";
import { BrowserRouter, Route, Switch } from "react-router-dom";

const Routes = () => (
    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/videos" exact>
                <VideoList />
            </Route>
            <Route path="/videos/:videoId">
                <VideoDetails />
            </Route>
            <Route path="/admin">
                <Admin />
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;