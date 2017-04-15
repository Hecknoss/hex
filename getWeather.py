#!/usr/bin/env python

## alias getweather='python ~/projects/py/getweather.py'
## newbie class practice time.

############# START MODULE #############

class GetPageContent(object):
    def __init__(self):
        self.name = None

    def get_page(self, url):
        try:
            import urllib
            return urllib.urlopen(url).read()
        except:
            return ''

    def scanner(self, page, tofind, endof):
        self.page = page
        self.tofind = tofind
        self.endof = endof

        self.start = self.page.find(self.tofind)
        self.end = self.page.find(self.endof, self.start)
        self.content = self.page[self.start + len(tofind):self.end]

        return self.content

############# END MODULE #############

def get_weather():
    #create instance
    link = 'http://www.bom.gov.au/vic/forecasts/melbourne.shtml'
    weather = GetPageContent()
    page = weather.get_page(link)

    #define variables to be used
    str1 = '<h2>'
    str1end = '</h2>'
    str2 = '<p>'
    str2end = '</p>'
    str3 = 'min">'
    str3end = '<'
    str4 = 'max">'
    str4end = '<'

    for i in range(7):
        print weather.scanner(page, str1, str1end)
        if (i > 0):
            print "min ", weather.scanner(page, str3, str3end)
            print "max ", weather.scanner(page, str4, str4end)

        page = page[weather.end:]
        print weather.scanner(page, str2, str2end)
        i += 1
        print "\n"

get_weather()
