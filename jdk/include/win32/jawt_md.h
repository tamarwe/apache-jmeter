/*===========================================================================
 * Licensed Materials - Property of IBM
 * "Restricted Materials of IBM"
 * 
 * IBM SDK, Java(tm) Technology Edition, v6
 * (C) Copyright IBM Corp. 2013, 2014. All Rights Reserved
 *
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *===========================================================================
 */
/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

#ifndef _JAVASOFT_JAWT_MD_H_
#define _JAVASOFT_JAWT_MD_H_

#include <windows.h>
                                                                                //IBM-awt_bringup
#define JNIEXPORT __declspec(dllexport)                                         //IBM-awt_bringup
#define JNIIMPORT __declspec(dllimport)                                         //IBM-awt_bringup
#ifdef _JNI_IMPLEMENTATION_                                                     //IBM-awt_bringup
#define _JNI_IMPORT_OR_EXPORT_ JNIEXPORT                                        //IBM-awt_bringup
#else                                                                           //IBM-awt_bringup
#define _JNI_IMPORT_OR_EXPORT_ JNIIMPORT                                        //IBM-awt_bringup
#endif                                                                          //IBM-awt_bringup

#include "jawt.h"                                                               //IBM-awt_bringup
#ifdef __cplusplus
extern "C" {
#endif

/*
 * Win32-specific declarations for AWT native interface.
 * See notes in jawt.h for an example of use.
 */
typedef struct jawt_Win32DrawingSurfaceInfo {
    /* Native window, DDB, or DIB handle */
    union {
        HWND hwnd;
        HBITMAP hbitmap;
        void* pbits;
    };
    /*
     * This HDC should always be used instead of the HDC returned from
     * BeginPaint() or any calls to GetDC().
     */
    HDC hdc;
    HPALETTE hpalette;
} JAWT_Win32DrawingSurfaceInfo;

#ifdef __cplusplus
}
#endif

#endif /* !_JAVASOFT_JAWT_MD_H_ */
//IBM-awt_bringup
