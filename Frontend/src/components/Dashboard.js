import React from 'react';
import DashboardService from '../services/DashboardService';
import { Link, Route } from "react-router-dom";

class Dashboard extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      photos:[],
      username: '',
      search: []
    }
  }

  componentDidMount() {
    DashboardService.getPhotos().then((Response) => {
      console.log(Response);
      this.setState({photos: Response.data})
    });
  }

  searchPhoto = (e) => {
    e.preventDefault();
    DashboardService.getPhoto(e.target.value).then((Response) => {
      this.setState({ photos: Response.data })
      console.log(Response);
      console.log(this.state.photos);
    });
  }

  render () {
    return (
      <div>
        <h1 className="text-center">Photo List</h1>
        <Link className='btn btn-primary' to="/">Logout</Link>
        <Link className='btn btn-primary' to="/addPhoto">Add Photo</Link>
        <input type="text" onChange={(e) => this.searchPhoto(e)} />
        <table className='table table-striped'>
          <thead>
            <tr>
              <td>Photo ID</td>
              <td>Photo name</td>
              <td>Photo</td>
            </tr>
          </thead>
          <tbody>
            {
              this.state.photos.map(
                photo =>
                <tr key = {photo.id}>
                    <td> {photo.id} </td>
                    <td> {photo.name} </td>
                    <td> <img src={`data:image/jpeg;base64,${photo.data}`} width="200" height="200" /> </td>
                </tr>
              )
            }
          </tbody>
        </table>
      </div>
    )
  }
}

export default Dashboard;