#!/usr/bin/env python

## Gets weather for melbourne.
## I have a bash alias that calls this script. 

#url for melbourne BOM nom
link = "http://www.bom.gov.au/vic/forecasts/melbourne.shtml"

def get_page(url):
    try:
        import urllib
        return urllib.urlopen(url).read()
    except:
        return ''

forcast_date = 'Forecast issued at'
page = get_page(link)

def forecast_start(link, item):

    start = link.find(item)
    end = link.find('</p>', start)
    date = link[start:end]
    page = link[end:]
    return date

##retreives relevant strings from website
def get_weather(link, s_link, e_link):
    start = link.find(s_link)
    end = link.find(e_link)
    thisday = link[start + len(s_link):end]
    return thisday, end

#return weather forecast for a day
def daily(page):

    for_day, endpos = get_weather(page, '<h2>', '</h2>')
    page = page[endpos:]

    forecast, endpos = get_weather(page, '<p>', '</p>')

    return page, for_day, forecast, endpos


def main(page):
    print '\n', forecast_start(page, forcast_date), '\n'
    for i in range(7):
        page, for_day, forecast, endpos = daily(page)
        page = page[endpos:]
        print '%s.\n%s\n' % (for_day, forecast)

main(page)
