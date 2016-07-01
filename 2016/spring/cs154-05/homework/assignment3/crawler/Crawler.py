import requests
from bs4 import BeautifulSoup
import validators
import queue

"""
    Author:      Scot Matson

    Description: Basic web crawler that collects web pages for later parsing.
                 Used to collect large data sets; to be used for learning
                 about MapReduce implementations.

                 Due to the large volume of web traffic this may potentially
                 produce, care should be used not to inadventently produce
                 a DDoS attack or violate a company's security policies.

    Version:     Alpha v0.1
    Change Log:  Data loss is high, but not something I'm worried about
                 at this time. Initial implementation is focused on
                 ability to crawl K-defined pages without error.
"""

page_number = 0

def crawl_web(seed_url, number_of_pages):
    seed = seed_url
    MAX_PAGES = number_of_pages
    global page_number
    q = queue.Queue()
    q.put(seed)
    visited = set() # Prevent revisiting

    while not q.empty() and page_number < MAX_PAGES:
        url = q.get()
        if url not in visited:
            scrape_page(url, q)
            visited.add(url)
        else:
            #print('Seen:',url)
            pass

def scrape_page(url, q):
    # Set user-agent to address cases in which sites are blocking
    # traffic unassociated with a web browser
    global page_number
    user_agent = {'User-Agent' : 'Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)'}
    timeout = 0.050
    try:
        # Requests for web requests
        r = requests.get(url, headers=user_agent, timeout=timeout)
        plain_text = r.text

        # BeautifulSoup for HTML parsing
        soup = BeautifulSoup(plain_text, 'html5lib')

        # Store page and increment counter
        save_page(url, soup.prettify())
        print('['+str(page_number)+']','Stored:',url)
        page_number += 1

        # This is where the actual scraping occurs
        # Probably should put this into its own function
        for line in soup.find_all('a'):
            href = str(line.get('href'))
            if (validators.url(href)):
                # Add scraped pages to the Queue
                q.put(line.get('href'))
            else:
                # Likely malformed. Okay to dump for now.
                # print('Malformed:',url)
                pass
    except:
        # To maintain efficiency, we are going to burn any page that
        # loads slowly, timesout, or has too many redirects.
        # print('Timeout:',url)
        pass

def save_page(url, source_code):
    global page_number
    file_path = 'web_pages' # For now, just use a local directory
    file_name = '/page_' + str(page_number)
    file_ext  = '.html'

    html_file = file_path+file_name+file_ext
    fh = open(html_file, 'a')
    fh.write('<!--'+url+'-->')
    fh.write(source_code)
    fh.close()
