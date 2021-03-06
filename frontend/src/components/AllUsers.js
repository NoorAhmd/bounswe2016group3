import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Link } from 'react-router'

import * as actions from '../actions/AllUsers';

class AllUsers extends Component {
    componentDidMount(){
        this.props.actions.load();


    }

    render(){
        
        if(!this.props.users){
            return (
                <article className="col-xs-12">
                    <p>
                        <i className="fa fa-circle-o-notch fa-spin fa-3x fa-fw"></i>
                        Loading...
                    </p>
                </article>
            );
        }

        if(this.props.users === []){
            return (
                <article className="col-xs-12">
                    <p>
                        No users
                    </p>
                </article>
            );
        }

        let userItems = this.props.users.map(function(user){

             if(user.userType == 0||user.userType == 2){
            return <li key={user.id}>
           
                <Link to={`/user/${user.id}`}>
                    <img src={user.avatarUrl} className="avatar-sm" alt="avatar" />
                    {user.fullName}
                </Link>
                </li>
            }
            else{
                 return <li key={user.id}>
                <Link to={`/foodServer/${user.id}`}>
                    <img src={user.avatarUrl} className="avatar-sm" alt="avatar" />
                    {user.fullName}
                </Link>   
            </li>
            }
                
            
            
        });

        return (
            <article className="col-xs-12">
                <ul>
                    {userItems}
                </ul>
            </article>
        );

    }
}

var mapStateToProps = function(state){
    return {
        users: state.users
    };
}

var mapDispatchToProps = function(dispatch){
    return { actions: bindActionCreators(actions, dispatch) };
}

export default connect(mapStateToProps, mapDispatchToProps)(AllUsers);