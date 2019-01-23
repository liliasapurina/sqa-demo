package com.sqa.demo.pages;

import com.sqa.demo.page_blocks.program.ProgramDataBlock;

@PageObject
public class ProgramPage {
    @PageBlock
    ProgramDataBlock programDataBlock;

    public ProgramPage verifySectionFinished() {
        programDataBlock.verifySectionFinished();
        return this;
    }
}
