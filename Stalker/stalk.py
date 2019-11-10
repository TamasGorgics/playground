#!/usr/bin/env python

import argparse
import webbrowser

parser = argparse.ArgumentParser(description='Stalker script v1.0')
parser.add_argument('name', type=str, nargs='*', help='Name of the person to stalk.')


def name(name):
    name_string = ''
    for i in name:
        name_string = name_string + i + ' '
    return name_string.strip()    


if __name__ == '__main__':
    args = parser.parse_args()
    if not args.name:
        print('Name required!')
    else:
        name_keyword = name(args.name)

        print('Opening browser tabs to stalk {}...'.format(name_keyword))

        webbrowser.open_new_tab('https://www.linkedin.com/search/results/all/?keywords={}'.format(name_keyword))
        webbrowser.open_new_tab('https://mrkoll.se/resultat?n={}&c=&min=16&max=120&sex=a&c_stat=all&company='.format(name_keyword))
        webbrowser.open_new_tab('https://www.facebook.com/search/top/?q={}&epa=SEARCH_BOX'.format(name_keyword))

        print('Done.')
