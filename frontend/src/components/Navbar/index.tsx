import {ReactComponent as GithubIcon } from 'assets/img/github.svg'
import './styles.css';

function Navbar() {
    return (
        <header>
          <nav className='container'>
            <div className='jcprmovie-nav-content'>
              <h1>JCPR Movie</h1>
              <a href="https://github.com/jcpr1980/">
                <div className='jcprmovie-contact-container'>
                  <GithubIcon/>
                  <p className='jcprmovie-contact-link'>/jcpr1980</p>
                </div>
                </a>
            </div>
          </nav>
        </header>
    
        );
    
}


export default Navbar;