[![Build Status](https://travis-ci.org/Tanaguru/Tanaguru.svg?branch=develop)](https://travis-ci.org/Tanaguru/Tanaguru) 
[![Join the chat at https://gitter.im/Tanaguru/Tanaguru](https://badges.gitter.im/Tanaguru/Tanaguru.svg)](https://gitter.im/Tanaguru/Tanaguru?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
# Tanaguru

Tanaguru is an opensource (AGPL license) website assessment tool. It is dedicated to accessibility (a11y) audits, and focuses on reliability and high level of automation.

## Features

Four kinds of audit:

* page audit
* entire website audit (Heritrix crawler embedded)
* scenario audit 
* offline file audit

(That's the DOM that is tested, thus dealing with JS/AJAX/ARIA)
 
## Vision

1. Automate as much as we can and even more :)
2. Be 200% reliable (don't give erroneous result)
3. have technological fun

## Download

http://download.tanaguru.org/Tanaguru/tanaguru-latest.tar.gz

## Demo

https://my.tanaguru.com/

## Installation and documentation

See [all Tanaguru Docs](http://tanaguru.readthedocs.org/)

[Rules implementation](http://tanaguru-rules-rgaa3.readthedocs.io/en/master/)

Usefull links:

* [Installation](http://tanaguru.readthedocs.org/en/develop/prerequisites-webapp-doc/)
* [Configuration](http://tanaguru.readthedocs.org/en/develop/configuration-webapp-doc/)
* [User Doc](http://tanaguru.readthedocs.org/en/develop/user-doc/)

## Business: accessibility

What tests are covered:

* all the "tag and attributes tests" like missing alt, table headers check, frame title...
* color contrast
* language specification
* downloadable files / office files (spreadsheet, wordprocessor...)
* switch of context
* ...

As of June 2016, this represents [~180 accessibility tests](http://rgaa.tanaguru.com/en/criteres.html)

## Contact and discussions

* [Tanaguru discussion space](http://discuss.tanaguru.org) 
* email to `support dot tanaguru AT oceaneconsulting dot com` (only English, French and klingon is spoken :) ) 
* [Twitter @TanaguruApp](https://twitter.com/tanaguruapp)

## Content of this last version (Tanaguru 4.0.3, 2017-02-20)

Features :

- Implementation of Rgaa3 rules (180 rules)

See full [Changelog](CHANGELOG.txt)

## Other Open Source tools

* [KBAccess](http://www.kbaccess.org/) : database of good and bad examples of web accessibility
* [Tanaguru Contrast-Finder](http://contrast-finder.tanaguru.com/) : for a given wrong contrast, *propose* good color combination
* [Accessibility observatory](http://observatoire-accessibilite.org/) : have an overview of the accessibility of a large set of websites
 
All these projects are opensource and also under the umbrella of [Tanaguru Github account](https://github.com/Tanaguru)

Have Fun

Tanaguru team
